package com.jfinal.zzl;

import com.jfinal.plugin.activerecord.ActiveRecordPlugin;
import com.jfinal.zzl.client.model.User;

public class _MappingKit {

	public static void mapping(ActiveRecordPlugin arp) {
		arp.addMapping("user", "id", User.class);
//		arp.addMapping("photo", Photo.class);
	}
}
