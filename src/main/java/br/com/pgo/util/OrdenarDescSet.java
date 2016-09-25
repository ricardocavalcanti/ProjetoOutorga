package br.com.pgo.util;

import java.util.Comparator;

import br.com.pgo.domain.Ua;

public class OrdenarDescSet implements Comparator<Ua>  {
	
	@Override
	public int compare(Ua ua1, Ua ua2) {

		if (ua2.getSet().compareTo(ua1.getSet()) == 1) {
			return 1;
		} else if (ua1.getSet().compareTo(ua2.getSet()) == 1) {
			return -1;
		} else {
			return 0;
		}
	}

}
