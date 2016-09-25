package br.com.pgo.util;

import java.util.Comparator;

import br.com.pgo.domain.Ua;

public class OrdenarDescJun implements Comparator<Ua> {

	@Override
	public int compare(Ua ua1, Ua ua2) {

		if (ua2.getJun().compareTo(ua1.getJun()) == 1) {
			return 1;
		} else if (ua1.getJun().compareTo(ua2.getJun()) == 1) {
			return -1;
		} else {
			return 0;
		}
	}
	
	
}
