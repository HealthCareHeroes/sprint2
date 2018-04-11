	package edu.uncc.ssdi.service;
	
	import static org.junit.Assert.assertEquals;
	
	import org.junit.Test;
	import org.junit.runner.RunWith;
	import org.springframework.boot.test.context.SpringBootTest;
	
	import edu.uncc.ssdi.dao.PermDao;
	import edu.uncc.ssdi.model.Permission;
	import mockit.Expectations;
	import mockit.Injectable;
	import mockit.Tested;
	import mockit.Verifications;
	import mockit.integration.junit4.JMockit;
	
	@SpringBootTest
	@RunWith(JMockit.class)
	public class PermServiceImplTest {
	
		
		@Injectable
		private PermDao permDao;
		
		@Tested
		private PermServiceImpl perm_service;
		
		@Test
		public void grantPermissionTest() {
			
			Permission permObject = new Permission();
			permObject.setId("08d556ea1-1df5-4f2e-919c-1348135f1419");
			permObject.setAccessByUserId((long)10002);
			permObject.setStatus(4)
			;
			
			new Expectations() {{
				permDao.givePermission(permObject); result = 1;
		 }};
		 
		int x = permDao.givePermission(permObject);
	
		 new Verifications() {{
			 assertEquals(1, x);
			
			 }};
			
		}
	
		
	}
