package com.codecool_mjs.dataaccess.dao;

import com.codecool_mjs.model.*;
import com.sun.org.apache.bcel.internal.classfile.Code;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

public class TeamMembershipDao extends MembershipDao<TeamMembership> {

    TeamMembershipDao() {
        super();
    }

    @Override
    TeamMembership createMembership(ResultSet results) throws  SQLException {
        Integer id = results.getInt(10);
        String name = results.getString(11);
        Team team = new Team(id, name);
        return new TeamMembership(team);
    }

    @Override
    TeamMembership getRelevantMembership(List<TeamMembership> memberships, Integer id) {
        for (TeamMembership teamMembership : memberships) {
            if (teamMembership.getTeam().getId().equals(id)) {
                return teamMembership;
            }
        }
        return null;
    }

    @Override
    String getQueryForGetAll() {
        return "SELECT * FROM team_membership" +
                " LEFT JOIN users" +
                " ON team_membership.user_id = users.id" +
                " LEFT JOIN teams" +
                " ON team_membership.team_id = teams.id;";
    }

    @Override
    void addMentorToMembership(TeamMembership teamMembership, Mentor mentor) {
    }

    @Override
    void addCodecoolerToMembership(TeamMembership teamMembership, Codecooler codecooler) {
        teamMembership.addCodecoolers(codecooler);
    }

    @Override
    void setInsertStatement(PreparedStatement ps, TeamMembership tm) {
    }

    @Override
    String getInsertQuery() {return "INSERT INTO group_membership (user_id, group_id) VALUES(?, ?);";}

}
