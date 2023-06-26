package com.inn.restaurant.serviceImpl;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Stream;

import org.apache.pdfbox.io.IOUtils;
import org.json.JSONArray;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.inn.restaurant.JWT.JwtFilter;
import com.inn.restaurant.constents.RestaurantConstents;
import com.inn.restaurant.dao.BillDao;
import com.inn.restaurant.pojo.Bill;
import com.inn.restaurant.service.BillService;
import com.inn.restaurant.utils.RestaurantUtils;
import com.itextpdf.text.BaseColor;
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Element;
import com.itextpdf.text.Font;
import com.itextpdf.text.FontFactory;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.Phrase;
import com.itextpdf.text.Rectangle;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;
import com.itextpdf.text.pdf.codec.Base64.InputStream;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class BillServiceImpl implements BillService {
	
	@Autowired
	JwtFilter jwtfilter;
	
	@Autowired
	BillDao billdao;

	@Override
	public ResponseEntity<String> generateReport(Map<String, Object> requestMap) {
//		log.info("inside");
		try {
			String filename;
			if(validateRequestMap(requestMap)) {
				
				if(requestMap.containsKey("isGenerate") && !(boolean) requestMap.get("isGenerate")) 
				{
					filename= (String) requestMap.get("uid");
				}else 
				{
					filename=RestaurantUtils.getuid();
					requestMap.put("uid", filename);
					insertbill(requestMap);
				}
				
				String data="Name: "+requestMap.get("name")+"\n"+"contact Number: " +requestMap.get("contactNumber")+
						"\n"+"Email :" +requestMap.get("email") +
						"\n"+"Payment Method :" +requestMap.get("paymentmethod");
				
				Document document=new Document();
				PdfWriter.getInstance(document, new FileOutputStream(RestaurantConstents.STORE_LOCATION+"\\"+filename+".pdf"));
				document.open();
				setRectangleInPdf(document);
				
				Paragraph chunk =new Paragraph("Restaurant Management System",getFont("header"));
				chunk.setAlignment(Element.ALIGN_CENTER);
				document.add(chunk);
				
				Paragraph paragraph =new Paragraph(data +"\n \n ", getFont("Data"));
				document.add(paragraph);
				PdfPTable table= new PdfPTable(5);
				table.setWidthPercentage(100);
				addTableHeader(table);
				
				JSONArray jsonarray = RestaurantUtils.getjsonArrayFromString((String) requestMap.get("productdetails"));
				for(int i=0; i< jsonarray.length();i++) 
				{
					
					addRows(table,RestaurantUtils.getMapFromJson(jsonarray.getString(i)));
					
				}
				document.add(table);
				
				Paragraph footer= new Paragraph("total:"+requestMap.get("totalamount")+"\n"+"Thank you for visiting.Please visit again!!",getFont("Data"));
				document.add(footer);
				document.close();
				return new ResponseEntity<>("{\"uid\":\""+filename+"\"}",HttpStatus.OK);
			}return RestaurantUtils.getResponseEntity("required data not found",HttpStatus.BAD_REQUEST);
			
		} catch (Exception e) {
			e.printStackTrace();
		}return RestaurantUtils.getResponseEntity(RestaurantConstents.SOMETHING_WENT_WRONG, HttpStatus.INTERNAL_SERVER_ERROR);
	}

	private void addRows(PdfPTable table, Map<String, Object> data) {
//		log.info("Inside addRows");
		table.addCell((String) data.get("name"));
		table.addCell((String) data.get("category"));
		table.addCell((String) data.get("quantity"));
		table.addCell(Double.toString((Double)data.get("price")));
		table.addCell(Double.toString((Double)data.get("total")));
}

	private void addTableHeader(PdfPTable table) {
		
//		log.info("Inside addTableHeader");
		Stream.of("Name","Category","Quantity","Price", "sub total").forEach(columnTitle->{
			PdfPCell header = new PdfPCell();
			header.setBackgroundColor(BaseColor.LIGHT_GRAY);
			header.setBorderWidth(2);
			header.setPhrase(new Phrase(columnTitle));
			header.setHorizontalAlignment(Element.ALIGN_CENTER);
			header.setVerticalAlignment(Element.ALIGN_CENTER);
			table.addCell(header);
		});
		
}

	private Font getFont(String type)
	{
//		log.info("inside getFont");
		
		switch (type) {
		case "Header":
			Font headerFont =FontFactory.getFont(FontFactory.HELVETICA_BOLDOBLIQUE, 18,BaseColor.BLACK);
			headerFont.setStyle(Font.BOLD);
			return headerFont;
			
		case "Data":
			Font dataFont = FontFactory.getFont(FontFactory.TIMES_ROMAN,11,BaseColor.BLACK);
			dataFont.setStyle(Font.BOLD);
			return dataFont;

		default:
			return new Font();
		}
	}

	private void setRectangleInPdf(Document document) throws DocumentException 
	{
//		log.info("inside setrectangleinpdf");
		Rectangle rect =new Rectangle(577,825,18,15);
		rect.enableBorderSide(1);
		rect.enableBorderSide(2);
		rect.enableBorderSide(4);
		rect.enableBorderSide(8);
		rect.setBorderColor(BaseColor.BLACK);
		rect.setBorderWidth(1);
		document.add(rect);
		
	}

	private void insertbill(Map<String, Object> requestMap) {
		try {
			Bill bill =new Bill();
			bill.setUuid((Long) requestMap.get("uid"));
			bill.setName((String)requestMap.get("name"));
			bill.setEmail((String)requestMap.get("email"));
			bill.setContactNumber((String)requestMap.get("contactNumber"));
			bill.setPaymentmethod((String)requestMap.get("paymentmethod"));
			bill.setTotal((double)requestMap.get("total"));
			bill.setProductdetails((String)requestMap.get("productdetails"));
			bill.setCreatedby(jwtfilter.getCurrentUser());
			billdao.save(bill);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}

	private boolean validateRequestMap(Map<String, Object> requestMap) {
		return requestMap.containsKey("name") &&
				requestMap.containsKey("contactNumber") &&
				requestMap.containsKey("email") &&
				requestMap.containsKey("paymentmethod") &&
				requestMap.containsKey("productdetails") &&
				requestMap.containsKey("totalamount");
	}

	@Override
	public ResponseEntity<List<Bill>> getBills() {
		List<Bill> list= new ArrayList<>();
		if(jwtfilter.isAdmin()) {
			list=billdao.getAllBills();
			
		}else {
			list=billdao.getBillByUserName(jwtfilter.getCurrentUser());
			
		}return new  ResponseEntity<>(list, HttpStatus.OK);
		
	}

	@Override
	public ResponseEntity<byte[]> getpdf(Map<String, Object> requestMap) {
		//log.info("Inside getPdf : requestMap{}",requestMap);
		try {
			byte[] byteArray= new byte[0];
			if(!requestMap.containsKey("uid") && validateRequestMap(requestMap)) {
				return new ResponseEntity<>(byteArray,HttpStatus.BAD_REQUEST);
			}
			
			String filepath = RestaurantConstents.STORE_LOCATION+"\\"+(String) requestMap.get("uid")+".pdf";
			if(RestaurantUtils.isFileExist(filepath)) {
				byteArray=getByteArray(filepath);
				return new ResponseEntity<> (byteArray,HttpStatus.OK);
			}else {
				requestMap.put("isGenerate", false);
				generateReport(requestMap);
				byteArray=getByteArray(filepath);
				return new ResponseEntity<>(byteArray,HttpStatus.OK);
			}
			
		} catch (Exception e) 
		{
			e.printStackTrace();
			
		}return null;
	}

	private byte[] getByteArray(String filepath) throws Exception {
		File initialfile = new File(filepath);
		FileInputStream targetstream = new FileInputStream(initialfile);
		byte[] byteArray =IOUtils.toByteArray(targetstream);
		targetstream.close();
		return byteArray;
	}

	@Override
	public ResponseEntity<String> deleteBill(Long id) {
		try {
			Optional optional =billdao.findById(id);
			if(!optional.isEmpty()) {
				
				billdao.deleteById(id);
				return RestaurantUtils.getResponseEntity("bill deleted succesfully", HttpStatus.OK);
			}
			return RestaurantUtils.getResponseEntity("Bill id doesnot exist", HttpStatus.OK);
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return RestaurantUtils.getResponseEntity(RestaurantConstents.SOMETHING_WENT_WRONG, HttpStatus.INTERNAL_SERVER_ERROR);
	}

}
