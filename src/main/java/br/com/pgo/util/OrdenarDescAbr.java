package br.com.pgo.util;

import java.util.Comparator;

import br.com.pgo.domain.Ua;

public class OrdenarDescAbr implements Comparator<Ua>  {
	
	@Override
	public int compare(Ua ua1, Ua ua2) {

		if (ua2.getAbr().compareTo(ua1.getAbr()) == 1) {
			return 1;
		} else if (ua1.getAbr().compareTo(ua2.getAbr()) == 1) {
			return -1;
		} else {
			return 0;
		}
	}

}
