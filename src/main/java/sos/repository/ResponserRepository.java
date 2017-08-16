package sos.repository;

import org.springframework.data.repository.CrudRepository;

import sos.domain.Responser;

public interface ResponserRepository extends CrudRepository<Responser,String>{

		public Responser findByDeviceId(String deviceId); 
}
