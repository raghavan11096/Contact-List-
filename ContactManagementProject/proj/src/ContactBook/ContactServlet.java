package ContactBook;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


import java.sql.Date;

/**
 * Servlet implementation class ContactServlet
 */
public class ContactServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private ContactDAO contactDAO;

	public void init() {
		String jdbcURL = getServletContext().getInitParameter("jdbcURL");
		String jdbcUsername = getServletContext().getInitParameter("jdbcUsername");
		String jdbcPassword = getServletContext().getInitParameter("jdbcPassword");

		contactDAO = new ContactDAO(jdbcURL, jdbcUsername, jdbcPassword);

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String action = request.getServletPath();

		try {
			switch (action) {
			case "/new":
				showNewForm(request, response);
				break;
			case "/insert":
				insertContact(request, response);
				break;
			case "/delete":
				deleteContact(request, response);
				break;
			case "/edit":
				showEditForm(request, response);
				break;
			case "/update":
				updateContact(request, response);
				break;
			case "/search":
				searchContact(request, response);
				break;
			default:
			listContact(request, response);
			break;
			
			}
		} catch (SQLException ex) {
			throw new ServletException(ex);
		}
	}

	private void listContact(HttpServletRequest request, HttpServletResponse response)
			throws SQLException, IOException, ServletException {
		List<Contact> listContact = contactDAO.listAllContacts();
		request.setAttribute("listContact", listContact);
		RequestDispatcher dispatcher = request.getRequestDispatcher("ContactList.jsp");
		dispatcher.forward(request, response);
	}

	private void showNewForm(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		RequestDispatcher dispatcher = request.getRequestDispatcher("ContactForm.jsp");
		dispatcher.forward(request, response);
	}

	private void showEditForm(HttpServletRequest request, HttpServletResponse response)
			throws SQLException, ServletException, IOException {
		int contact_id = Integer.parseInt(request.getParameter("contact_id"));
		Contact existingContact = contactDAO.getContact(contact_id);
		RequestDispatcher dispatcher = request.getRequestDispatcher("ContactForm.jsp");
		request.setAttribute("contact", existingContact);
		dispatcher.forward(request, response);

	}

	private void insertContact(HttpServletRequest request, HttpServletResponse response) 
			throws SQLException, IOException {
		String first_name = request.getParameter("first_name");
		String middle_name = request.getParameter("middle_name");
		String last_name = request.getParameter("last_name");
		String home_phone = request.getParameter("home_phone");
		String cell_phone = request.getParameter("cell_phone");
		String home_address = request.getParameter("home_address");
		String home_city = request.getParameter("home_city");
		String home_state = request.getParameter("home_state");
		int home_zip = Integer.parseInt(request.getParameter("home_zip"));
		String work_phone = request.getParameter("work_phone");
		String work_address = request.getParameter("work_address");
		String work_city = request.getParameter("work_city");
		String work_state = request.getParameter("work_state");
		int work_zip = Integer.parseInt(request.getParameter("work_zip"));
		Date birth_date=Date.valueOf(request.getParameter("birth_date"));
		Contact newContact = new Contact(first_name, middle_name, last_name, home_phone, cell_phone, home_address, home_city,home_state,home_zip,work_phone,work_address,work_city,work_state,work_zip,birth_date);
		contactDAO.insertContact(newContact);
		response.sendRedirect("list");
	}

	private void updateContact(HttpServletRequest request, HttpServletResponse response) 
			throws SQLException, IOException {
		int contact_id = Integer.valueOf(request.getParameter("contact_id"));
		String first_name = request.getParameter("first_name");
		String middle_name = request.getParameter("middle_name");
		String last_name = request.getParameter("last_name");
		String home_phone = request.getParameter("home_phone");
		String cell_phone = request.getParameter("cell_phone");
		String home_address = request.getParameter("home_address");
		String home_city = request.getParameter("home_city");
		String home_state = request.getParameter("home_state");
		int home_zip = Integer.valueOf(request.getParameter("home_zip"));
		String work_phone = request.getParameter("work_phone");
		String work_address = request.getParameter("work_address");
		String work_city = request.getParameter("work_city");
		String work_state = request.getParameter("work_state");
		int work_zip = Integer.valueOf(request.getParameter("work_zip"));
		Date birth_date=Date.valueOf(request.getParameter("birth_date"));
		

		Contact contact = new Contact(contact_id, first_name, middle_name, last_name, home_phone, cell_phone, home_address, home_city,home_state,home_zip,work_phone,work_address,work_city,work_state,work_zip,birth_date);
		contactDAO.updateContact(contact);
		response.sendRedirect("list");
	}

	private void deleteContact(HttpServletRequest request, HttpServletResponse response) 
			throws SQLException, IOException {
		int contact_id = Integer.parseInt(request.getParameter("contact_id"));

		Contact contact = new Contact(contact_id);
		contactDAO.deleteContact(contact);
		response.sendRedirect("list");

	}
	
	private void searchContact(HttpServletRequest request, HttpServletResponse response) 
			throws SQLException, IOException, ServletException {
		String search_contact=request.getParameter("search_contact");
		List<Contact> searchContact = contactDAO.searchContact(search_contact);
		request.setAttribute("listContact", searchContact);
		RequestDispatcher dispatcher = request.getRequestDispatcher("ContactList.jsp");
		dispatcher.forward(request, response);


	}

}

