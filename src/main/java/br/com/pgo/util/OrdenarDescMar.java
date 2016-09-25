package br.com.pgo.util;

import java.util.Comparator;

import br.com.pgo.domain.Ua;

public class OrdenarDescMar implements Comparator<Ua> {
	
	
	@Override
	public int compare(Ua ua1, Ua ua2) {

		if (ua2.getMar().compareTo(ua1.getMar()) == 1) {
			return 1;
		} else if (ua1.getMar().compareTo(ua2.getMar()) == 1) {
			return -1;
		} else {
			return 0;
		}
	}

}
