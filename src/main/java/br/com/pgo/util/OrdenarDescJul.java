package br.com.pgo.util;

import java.util.Comparator;

import br.com.pgo.domain.Ua;

public class OrdenarDescJul implements Comparator<Ua> {
	
	@Override
	public int compare(Ua ua1, Ua ua2) {

		if (ua2.getJul().compareTo(ua1.getJul()) == 1) {
			return 1;
		} else if (ua1.getJul().compareTo(ua2.getJul()) == 1) {
			return -1;
		} else {
			return 0;
		}
	}

}
