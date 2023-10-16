package nl.acme.running.api;

import nl.acme.running.domain.Run;
import nl.acme.running.service.RunService;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Optional;

@CrossOrigin
@RestController
@RequestMapping("api/runs")
public class RunController {

	@Autowired
	private RunService runService;

	@GetMapping
	public ResponseEntity<Iterable<Run>> list() {
		return ResponseEntity.ok(runService.findAll());
	}

	@PostMapping
	public ResponseEntity<Run> create(@RequestBody Run run) {
		return ResponseEntity.ok(this.runService.save(run));
	}

	@GetMapping("{id}")
	public ResponseEntity<Run> findById(@PathVariable long id) {
		Optional<Run> optionalRun = this.runService.findById(id);
		if(optionalRun.isPresent()) {
			return ResponseEntity.ok(optionalRun.get());
		}
		else {
			return ResponseEntity.notFound().build();
		}
	}

	@PutMapping("{id}")
	public ResponseEntity<Run> updateById(@PathVariable long id, @RequestBody Run source) {
		Optional<Run> optionalRun = this.runService.findById(id);
		if(optionalRun.isPresent()) {
			Run target = optionalRun.get();
			target.setStart(source.getStart());
			target.setFinish(source.getFinish());
			target.setDistance(source.getDistance());

			return ResponseEntity.ok(this.runService.save(target));
		}
		else {
			return ResponseEntity.notFound().build();
		}
	}

	@DeleteMapping("{id}")
	public ResponseEntity<Void> deleteById(@PathVariable long id) {
		Optional<Run> optionalRun = this.runService.findById(id);
		if(optionalRun.isPresent()) {
			this.runService.deleteById(id);

			return ResponseEntity.noContent().build();
		}
		else {
			return ResponseEntity.notFound().build();
		}
	}
}
