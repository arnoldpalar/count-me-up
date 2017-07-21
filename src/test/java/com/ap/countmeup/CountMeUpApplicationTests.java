package com.ap.countmeup;

import com.ap.countmeup.dto.VoteRequest;
import com.ap.countmeup.exception.InvalidVoteException;
import com.ap.countmeup.repository.VoteRepo;
import com.ap.countmeup.service.CountService;
import com.ap.countmeup.service.VoteService;
import org.junit.Assert;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.MethodSorters;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;
import java.util.Random;

@RunWith(SpringRunner.class)
@SpringBootTest
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class CountMeUpApplicationTests {

	@Autowired
	private CountService countService;

	@Autowired
	private VoteService voteService;

	@Autowired
	private VoteRepo voteRepo;

	@Test
	public void aContextLoads() throws Exception {

		Random randomVoter = new Random();
		Random randomCandidate = new Random();

		int nofVotes = 10000000;
		int nofVoters = 3000000;
		int nofCandidates = 5;

		for(int i = 0; i < nofVotes; i++) {
			Long voterId = new Integer(randomVoter.nextInt(nofVoters)).longValue();
			Long candidateId = new Integer(randomCandidate.nextInt(nofCandidates)).longValue();

			try {
				voteService.vote(new VoteRequest(voterId, candidateId));
			} catch (InvalidVoteException e) {
				List<Long> votes = voteRepo.getVotes(voterId);
				Assert.assertTrue(votes != null && (votes.size() >= 3 || votes.contains(candidateId)));
			}
		}

	}

	@Test
	public void bTotalVotesConsistency() {
		Assert.assertTrue(countService
											.count()
											.values()
											.stream()
											.mapToLong(Long::longValue)
											.sum()
										== voteRepo.total());
	}

}
