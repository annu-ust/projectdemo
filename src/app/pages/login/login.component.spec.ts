import { LoginComponent } from './login.component';
import { Router } from '@angular/router';
import { User } from 'src/app/model/User';
import { AuthserviceService } from 'src/app/services/authservice.service';
import { UserService } from 'src/app/services/user.service';

describe('LoginComponent', () => {
  let component: LoginComponent;
  let router: jasmine.SpyObj<Router>;
  let authService: jasmine.SpyObj<AuthserviceService>;
  let userService: jasmine.SpyObj<UserService>;

  beforeEach(() => {
    router = jasmine.createSpyObj('Router', ['navigateByUrl']);
    authService = jasmine.createSpyObj('AuthserviceService', ['login']);
    userService = jasmine.createSpyObj('UserService', ['fetchUser']);

    component = new LoginComponent(router, userService, authService);
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });

  describe('login', () => {
    it('should call authService.login with email and password', () => {
      // Arrange
      component.user.email = 'test@example.com';
      component.user.password = 'password';

      // Act
      component.login();

      // Assert
      expect(authService.login).toHaveBeenCalledWith('test@example.com', 'password');
    });
  });

  describe('getUserRole', () => {
    it('should get user role from localStorage', () => {
      // Arrange
      spyOn(localStorage, 'getItem').and.returnValue('admin');

      // Act
      const role = component.getUserRole();

      // Assert
      expect(localStorage.getItem).toHaveBeenCalledWith('userRole');
      expect(role).toEqual('admin');
    });
  });

  describe('navigateToReset', () => {
    it('should navigate to reset-password route', () => {
      // Act
      component.navigateToReset();

      // Assert
      expect(router.navigateByUrl).toHaveBeenCalledWith('/reset-password');
    });
  });
});
