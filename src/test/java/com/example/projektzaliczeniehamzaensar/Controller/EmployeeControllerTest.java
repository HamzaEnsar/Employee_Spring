package com.example.projektzaliczeniehamzaensar.Controller;

import com.example.projektzaliczeniehamzaensar.Model.Employee;
import com.example.projektzaliczeniehamzaensar.Repository.EmployeeRepository;
import com.example.projektzaliczeniehamzaensar.Service.EmployeeService;

import org.h2.engine.Database;
import org.hamcrest.Matchers;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultMatcher;

import java.util.ArrayList;

import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@WebMvcTest(EmployeeController.class)
@ExtendWith(MockitoExtension.class)
class EmployeeControllerTest {

    @Autowired
    private MockMvc mockMvc;
    @MockBean
    private EmployeeService employeeService;
    @MockBean
    private EmployeeRepository employeeRepository;


    @BeforeEach
    void setUp() {


    }


    @Test
    void createEmployee() {


    }

    @Test
    void getAllEmployee() throws Exception {

        Employee employee2 = new Employee();
        Employee employee1=new Employee();

        employee2.setFirstName("Hamza");
        employee2.setLastName("surname");
        employee2.setPhone(123123);
        employee2.setDepartment("IT");
        employee2.setEmail("aaa@aaaa");
        employee2.setCity("Ankara");
        employee2.setSalary(123123);

        employee1.setFirstName("Tahsin");
        employee1.setLastName("Shan");
        employee1.setPhone(123123);
        employee1.setDepartment("IT");
        employee1.setEmail("aaa@aaaa");
        employee1.setCity("Ankara");
        employee1.setSalary(999999);

        ArrayList<Employee> employees0 = new ArrayList<>();
        employees0.add(employee2);
        employees0.add(employee1);

        when(employeeRepository.findAll()).thenReturn(employees0);
        mockMvc.perform(get("/get").accept(MediaType.APPLICATION_JSON)).andExpect(status().isOk()).andExpect(jsonPath("$.FirstName", Matchers.is("Hamza")));

        Mockito.verify(employeeRepository.findAll());
    }

    @Test
    void deleteEmployee() {
    }

    @Test
    void getEmployeeById() {

    }

    @Test
    void updateEmployee() {
    }



//    @ExtendWith(MockitoExtension.class)
//    public class UserControllerTest {
//
//        @Mock
//        UserService userService;
//
//        @InjectMocks
//        UserController underTest;
//
//
//        @Test
//        void getUserByIdTest() {
//            UserDTO userDTO=new UserDTO();
//
//            userDTO.setId(1L);
//            userDTO.setEmail("a@email.com");
//
//            HttpServletRequest request=mock(HttpServletRequest.class);
//
//            when(userService.findById(1L)).thenReturn(userDTO);
//
//            when(request.getAttribute("id")).thenReturn(1L);
//
//
//            ResponseEntity<UserDTO> userResponse=underTest.getUserById(request);
//            UserDTO actual=userResponse.getBody();
//
//            assertAll(
//                    ()->assertNotNull(actual),
//                    ()->assertEquals(HttpStatus.OK, userResponse.getStatusCode()),
//                    ()->assertEquals(1L, actual.getId())
//            );
//        }
//

    }
