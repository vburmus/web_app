import com.my.command.filter.ProductsFilterCommand;
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

class ProductsFilterCommandTest {
    @Test
    void deniedAccess1() throws IOException, ServletException {
        final ProductsFilterCommand productsFilterCommand = new ProductsFilterCommand();
        final HttpSession session = mock(HttpSession.class);
        final HttpServletRequest request = mock(HttpServletRequest.class);
        final HttpServletResponse response = mock(HttpServletResponse.class);
        when(request.getSession()).thenReturn(session);
        when(request.getContextPath()).thenReturn("/cashregister");
        final String loginPath = request.getContextPath() + "/controller?command=LOGIN_PAGE";
        final String profilePath = request.getContextPath() + "/controller?command=PROFILE_PAGE";

            when(session.getAttribute("user")).thenReturn(null);
            productsFilterCommand.getAccess(request, response);
            verify(response, times(1)).sendRedirect(loginPath);

    }
    @Test
    void openedAccess() throws IOException, ServletException {
        final ProductsFilterCommand productsFilterCommand = new ProductsFilterCommand();
        final HttpSession session = mock(HttpSession.class);
        final HttpServletRequest request = mock(HttpServletRequest.class);
        final HttpServletResponse response = mock(HttpServletResponse.class);
        when(request.getSession()).thenReturn(session);
        when(request.getContextPath()).thenReturn("/cashregister");
        Employee employee = new Employee();
        employee.setRole(4);
        when(session.getAttribute("user")).thenReturn(employee);
        productsFilterCommand.getAccess(request,response);
        final String loginPath = request.getContextPath() + "/controller?command=LOGIN_PAGE";
        final String profilePath = request.getContextPath() + "/controller?command=PROFILE_PAGE";
        verify(response,never()).sendRedirect(profilePath);
    }
}