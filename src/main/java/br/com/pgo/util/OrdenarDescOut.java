package br.com.pgo.util;

import java.util.Comparator;

import br.com.pgo.domain.Ua;

public class OrdenarDescOut implements Comparator<Ua>  {
	
	@Override
	public int compare(Ua ua1, Ua ua2) {

		if (ua2.getOut().compareTo(ua1.getOut()) == 1) {
			return 1;
		} else if (ua1.getOut().compareTo(ua2.getOut()) == 1) {
			return -1;
		} else {
			return 0;
		}
	}

}
