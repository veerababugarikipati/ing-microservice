/*package com.hcl.spring.boot.training.serviceTest;

import java.util.Optional;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;

import com.hcl.spring.boot.training.repositories.UserRepository;
import com.hcl.spring.boot.training.service.UserService;
import com.hcl.spring.boot.training.service.UserServiceImpl;

public class UserServiceTest {
	private UserService userService= new UserServiceImpl();
    private UserRepository userRepositoryMock;
    @Before
    public void setUp() {
    	userRepositoryMock = Mockito.mock(UserRepository.class);
    }
    @Test
    public void createUserSuccessfuly() throws Exception {
        when(userRepositoryMock.findByName(eq("Foo"))).thenReturn(Optional.empty());
        doAnswer(returnsFirstArg()).when(clientRepositoryMock).save(any(Client.class));
        Client client = createClientService.createClient("Foo");
        assertEquals("Foo", client.getName());
        assertNotNull(client.getNumber());
    }
}
*/