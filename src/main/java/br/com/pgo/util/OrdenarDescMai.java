package br.com.pgo.util;

import java.util.Comparator;

import br.com.pgo.domain.Ua;

public class OrdenarDescMai implements Comparator<Ua> {
	
	
	@Override
	public int compare(Ua ua1, Ua ua2) {

		if (ua2.getMai().compareTo(ua1.getMai()) == 1) {
			return 1;
		} else if (ua1.getMai().compareTo(ua2.getMai()) == 1) {
			return -1;
		} else {
			return 0;
		}
	}

}
