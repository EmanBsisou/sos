package sos.services;

import sos.domain.Responser;

public interface ResponserService {

	public Responser createUpdateResponser(Responser responser);
	public Responser getResponserByDeviceId(String deviceId);
	public Responser getResponserById(String responserId);
}
