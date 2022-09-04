import com.my.command.filter.AdminOnlyFilterCommand;
import com.my.model.Employee;
import org.junit.jupiter.api.Test;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;
import static org.mockito.Mockito.times;

class AdminOnlyFilterCommandTest {

    @Test
    void giveAccess() throws IOException, ServletException {
        final AdminOnlyFilterCommand adminOnlyFilterCommand = new AdminOnlyFilterCommand();
        final HttpSession session = mock(HttpSession.class);
        final HttpServletRequest request = mock(HttpServletRequest.class);
        final HttpServletResponse response = mock(HttpServletResponse.class);
        when(request.getSession()).thenReturn(session);
        when(request.getContextPath()).thenReturn("/cashregister");
        Employee employee = new Employee();
        employee.setRole(1);
        when(session.getAttribute("user")).thenReturn(employee);
        final String profilePath = request.getContextPath() + "/controller?command=PROFILE_PAGE";
       adminOnlyFilterCommand.getAccess(request,response);
        verify(response,never()).sendRedirect(profilePath);
    }
    @Test
    void deniedAccess() throws IOException, ServletException {
        final AdminOnlyFilterCommand adminOnlyFilterCommand = new AdminOnlyFilterCommand();

        final HttpSession session = mock(HttpSession.class);
        final HttpServletRequest request = mock(HttpServletRequest.class);
        final HttpServletResponse response = mock(HttpServletResponse.class);
        when(request.getSession()).thenReturn(session);
        when(request.getContextPath()).thenReturn("/cashregister");

        final String profilePath = request.getContextPath() + "/controller?command=PROFILE_PAGE";
        final String loginPath = request.getContextPath() + "/controller?command=LOGIN_PAGE";
        when(session.getAttribute("user")).thenReturn(null);
        adminOnlyFilterCommand.getAccess(request,response);
        verify(response,times(1)).sendRedirect(loginPath);
        Employee employee = new Employee();
        for(int i = 2; i < 5;i++) {

            employee.setRole(i);
            when(session.getAttribute("user")).thenReturn(employee);
            adminOnlyFilterCommand.getAccess(request, response);
            verify(response, times(i-1)).sendRedirect(profilePath);
        }
    }
}