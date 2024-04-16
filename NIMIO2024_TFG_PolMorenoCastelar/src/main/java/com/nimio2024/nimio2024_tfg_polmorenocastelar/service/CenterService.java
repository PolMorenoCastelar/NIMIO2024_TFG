package com.nimio2024.nimio2024_tfg_polmorenocastelar.service;

import com.nimio2024.nimio2024_tfg_polmorenocastelar.domain.Center;


import java.util.List;


public interface CenterService {

    public List<Center> getCenters();

    public Center createCenter(Center center);

    public Center getCenter(Long centerId);

    public void deleteCenter(Long centerId);


}
