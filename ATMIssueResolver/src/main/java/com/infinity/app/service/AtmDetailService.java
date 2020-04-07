package com.infinity.app.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.infinity.app.model.AtmDetail;
import com.infinity.app.repo.AtmDetailRepo;

@Service
public class AtmDetailService {

	@Autowired
	private AtmDetailRepo atmRepo;

	public AtmDetail getAtmDetail(String terminalId) {
		return atmRepo.getAtmDetail(terminalId);
	}
	public AtmDetail save(AtmDetail atmDetail) {
		return atmRepo.save(atmDetail);
	}
}
