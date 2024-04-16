package service;

import domain.Center;


import java.util.List;


public interface CenterService {

    public List<Center> getCenters();

    public Center createCenter(Center center);

    public Center getCenter(Long centerId);

    public void deleteCenter(Long centerId);


}
