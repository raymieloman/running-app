package nl.acme.running.service;

import nl.acme.running.domain.Run;
import nl.acme.running.persistence.RunRepository;
import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
public class RunService {

	@Autowired
	private RunRepository runRepository;

	public Iterable<Run> findAll() {
		return runRepository.findAll();
	}

	@Transactional
	public Run save(Run run) {
		return runRepository.save(run);
	}

	public Optional<Run> findById(long id) {
		return runRepository.findById(id);
	}

	@Transactional
	public void deleteById(long id) {
		runRepository.deleteById(id);
	}
}
