package br.com.pgo.util;

import java.util.Comparator;

import br.com.pgo.domain.Ua;

public class OrdenarDescAgo implements Comparator<Ua>  {
	
	@Override
	public int compare(Ua ua1, Ua ua2) {

		if (ua2.getAgo().compareTo(ua1.getAgo()) == 1) {
			return 1;
		} else if (ua1.getAgo().compareTo(ua2.getAgo()) == 1) {
			return -1;
		} else {
			return 0;
		}
	}

}
