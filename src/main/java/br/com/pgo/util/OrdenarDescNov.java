package br.com.pgo.util;

import java.util.Comparator;

import br.com.pgo.domain.Ua;

public class OrdenarDescNov implements Comparator<Ua>  {
	
	@Override
	public int compare(Ua ua1, Ua ua2) {

		if (ua2.getNov().compareTo(ua1.getNov()) == 1) {
			return 1;
		} else if (ua1.getNov().compareTo(ua2.getNov()) == 1) {
			return -1;
		} else {
			return 0;
		}
	}

}
