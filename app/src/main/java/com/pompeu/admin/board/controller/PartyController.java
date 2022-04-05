package com.pompeu.admin.board.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.pompeu.admin.board.service.PartyService;
import com.pompeu.domain.Member;
import com.pompeu.domain.Party;
import com.pompeu.domain.PartyClaim;

@RestController 
public class PartyController {


  @Autowired
  PartyService partyService;

  @RequestMapping("/party/list")
  public Object list() {
    return partyService.list();
  }

  @RequestMapping("/party/add")
  public Object add(Party party) {
    return partyService.add(party);
  }

  @RequestMapping("/party/get")
  public Object get(int no) {
    Party party = partyService.get(no);
    return party != null ? party : "";
  }

  @RequestMapping("/party/update")
  public Object update(Party party) {
    return partyService.update(party);
  }

  @RequestMapping("/party/delete")
  public Object delete(int no) {
    return partyService.delete(no);
  }

  @RequestMapping("/party/srchParty")
  public Object srchParty(Party party, Member member, PartyClaim partyclaim ) {

    System.out.println("srchParty : " + party.getPartyNo());
    System.out.println("srchParty : " + party.getName());
    System.out.println("srchParty : " + member.getName());
    System.out.println("srchParty : " + party.getRegisterDate());
    System.out.println("srchParty : " + partyclaim.getStatus());

    System.out.println(partyService.srchParty(party));
    return partyService.srchParty(party);
  }


  @RequestMapping("/party/partyClaim")
  public Object partyClaim() {
    return partyService.findPartyClaim();
  }

  @RequestMapping("/party/PartyList")
  public Object PartyList() {
    return partyService.findPartyList();
  }

}