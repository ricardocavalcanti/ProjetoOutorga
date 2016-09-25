package br.com.pgo.util;

import java.util.Comparator;

import br.com.pgo.domain.Ua;

public class OrdenarDescJan implements Comparator<Ua> {

	@Override
	public int compare(Ua ua1, Ua ua2) {

		if (ua2.getJan().compareTo(ua1.getJan()) == 1) {
			return 1;
		} else if (ua1.getJan().compareTo(ua2.getJan()) == 1) {
			return -1;
		} else {
			return 0;
		}
	}
	
}
