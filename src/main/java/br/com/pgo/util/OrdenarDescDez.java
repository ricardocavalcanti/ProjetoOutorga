package br.com.pgo.util;

import java.util.Comparator;

import br.com.pgo.domain.Ua;

public class OrdenarDescDez implements Comparator<Ua>  {
	
	@Override
	public int compare(Ua ua1, Ua ua2) {

		if (ua2.getDez().compareTo(ua1.getDez()) == 1) {
			return 1;
		} else if (ua1.getDez().compareTo(ua2.getDez()) == 1) {
			return -1;
		} else {
			return 0;
		}
	}

}
