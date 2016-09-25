package br.com.pgo.util;

import java.util.Comparator;

import br.com.pgo.domain.Ua;

public class OrdenarDescFev implements Comparator<Ua> {
	
	@Override
	public int compare(Ua ua1, Ua ua2) {

		if (ua2.getFev().compareTo(ua1.getFev()) == 1) {
			return 1;
		} else if (ua1.getFev().compareTo(ua2.getFev()) == 1) {
			return -1;
		} else {
			return 0;
		}
	}

}
