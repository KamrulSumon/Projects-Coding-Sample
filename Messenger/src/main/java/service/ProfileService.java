package org.sumon.rest.messenger.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.sumon.rest.messenger.database.DatabaseClass;
import org.sumon.rest.messenger.model.Message;
import org.sumon.rest.messenger.model.Profile;

import javassist.compiler.ast.NewExpr;

public class ProfileService {

	private Map<String, Profile> profiles = DatabaseClass.getProfiles();
	
	public ProfileService(){
		profiles.put("sumon", new Profile(1L, "sumon", "main", "Kamrul"));
	}
	
	public List<Profile> getAllProfiles(){
		return new ArrayList<>(profiles.values());
	}
	
	public Profile getProfile(String name){
		return profiles.get(name);
	}
	
	public Profile addProfile(Profile profile){
		profile.setId(profiles.size() + 1);
		profiles.put(profile.getProfileName(), profile);
		return profile;
	}
	
	
	public Profile updateProfile(Profile profile){
		if(profile.getProfileName().isEmpty() ){
			return null;
		}
		profiles.put(profile.getProfileName(), profile);
		return profile;
	}
	
	public Profile removeProfile(String name){
		return profiles.remove(name);
	}

}
