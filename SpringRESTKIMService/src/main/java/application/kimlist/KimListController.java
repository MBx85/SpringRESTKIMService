package application.kimlist;

import java.util.ArrayList;
import java.util.logging.Logger;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class KimListController {

	private static final Logger log = Logger.getLogger(KimListController.class.getName());
	private static final int KIMAmount = 300000;
	private static final int KimLength = 15;

	/*
	 * @RequestMapping(value = "/KIMList", method = RequestMethod.GET) public
	 * KimList ReturnKimList() {
	 * 
	 * /*for (int i = 1; i<= KIMAmount ;i++) {
	 * 
	 * }
	 * 
	 * String[] k = {"A", "B" , "AA"}; KimList kl = new KimList(); kl.setKims(k);
	 * return kl; }
	 */

	@RequestMapping(value = "/KIMList", method = RequestMethod.GET)
	public KimArrayList ReturnKimListAL() {
		ArrayList<String> al = new ArrayList<String>();
		for (int i = 1; i <= KIMAmount; i++) {
			
			StringBuffer sb = new StringBuffer();
			
			for (int j = 1; j <= KimLength;j++) {
				sb.append((int) (Math.random()*10));
			}
			
			al.add(sb.toString());
		}
		KimArrayList kal = new KimArrayList();
		kal.setKims(al);
		return kal;
	}

}
