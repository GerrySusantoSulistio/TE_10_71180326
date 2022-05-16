import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

public class TestTE {
     User user = Mockito.mock(User.class);

     UserDAO userDAO = Mockito.mock(UserDAO.class);
     SecurityService securityService = Mockito.mock(SecurityService.class);

     @Test
     public void testSendMain() throws Exception {
          UserServiceImpl sut= new UserServiceImpl(userDAO,securityService);

          Mockito.when(securityService.md5(user.getPassword())).thenReturn("password");
          Mockito.when(userDAO.updateUser(user)).thenReturn("password");

          sut.assignPassword(user);
          Mockito.verify(user).setPassword("password");
          Mockito.verify(userDAO).updateUser(user);
     }
}
