import com.my.command.filter.CommodityExceptFilterCommand;
import com.my.model.Employee;
import org.junit.jupiter.api.Test;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;
import static org.mockito.Mockito.never;

class NewProductFilterCommandTest {
    @Test
    void giveAccess() throws IOException, ServletException {
        final CommodityExceptFilterCommand commodityExceptFilterCommand = new CommodityExceptFilterCommand();
        final HttpSession session = mock(HttpSession.class);
        final HttpServletRequest request = mock(HttpServletRequest.class);
        final HttpServletResponse response = mock(HttpServletResponse.class);
        when(request.getSession()).thenReturn(session);
        when(request.getContextPath()).thenReturn("/cashregister");
        final String loginPath = request.getContextPath() + "/controller?command=LOGIN_PAGE";
        final String profilePath = request.getContextPath() + "/controller?command=PROFILE_PAGE";
        Employee employee = new Employee();
        for(int i = 1;i<4;i++) {
            employee.setRole(i);
            when(session.getAttribute("user")).thenReturn(employee);
            commodityExceptFilterCommand.getAccess(request, response);
            verify(response, never()).sendRedirect(profilePath);
        }
    }
    @Test
    void deniedAccess() throws IOException, ServletException {
        final CommodityExceptFilterCommand commodityExceptFilterCommand = new CommodityExceptFilterCommand();
        final HttpSession session = mock(HttpSession.class);
        final HttpServletRequest request = mock(HttpServletRequest.class);
        final HttpServletResponse response = mock(HttpServletResponse.class);
        when(request.getSession()).thenReturn(session);
        when(request.getContextPath()).thenReturn("/cashregister");
        when(session.getAttribute("user")).thenReturn(null);
        commodityExceptFilterCommand.getAccess(request,response);
        final String loginPath = request.getContextPath() + "/controller?command=LOGIN_PAGE";
        final String profilePath = request.getContextPath() + "/controller?command=PROFILE_PAGE";
        verify(response,times(1)).sendRedirect(loginPath);
    }
}