package com.event.managements.services;

import com.event.managements.model.Program;
import com.event.managements.repositories.ProgramRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProgramService {

    @Autowired
    private ProgramRepository programRepository;

    public Program addProgram(Program program) {
        return programRepository.save(program);
    }

    public List<Program> getProgramsByEventId(Long eventId) {
        return programRepository.findByEventId(eventId);
    }

    public List<Program> getAllPrograms() {
        return programRepository.findAll();
    }

    public Optional<Program> getProgramById(Long id) {
        return programRepository.findById(id);
    }

    public Program updateProgram(Long id, Program programDetails) {
        Optional<Program> optionalProgram = programRepository.findById(id);
        if (optionalProgram.isPresent()) {
            Program program = optionalProgram.get();
            program.setTitle(programDetails.getTitle());
            program.setEvent(programDetails.getEvent());
            program.setProgramType(programDetails.getProgramType());
            program.setStartTime(programDetails.getStartTime());
            program.setEndTime(programDetails.getEndTime());
            program.setParticipants(programDetails.getParticipants());
            program.setDescription(programDetails.getDescription());
            return programRepository.save(program);
        } else {
            throw new RuntimeException("Program not found with id " + id);
        }
    }

    public void deleteProgram(Long id) {
        programRepository.deleteById(id);
    }
}
