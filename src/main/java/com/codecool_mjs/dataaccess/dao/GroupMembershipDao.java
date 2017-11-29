package com.codecool_mjs.dataaccess.dao;

import com.codecool_mjs.model.Codecooler;
import com.codecool_mjs.model.Group;
import com.codecool_mjs.model.GroupMembership;
import com.codecool_mjs.model.Mentor;
import com.sun.org.apache.bcel.internal.classfile.Code;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

public class GroupMembershipDao extends MembershipDao<GroupMembership> {

    public GroupMembershipDao() {
        super();
    }

    @Override
    GroupMembership createMembership(ResultSet results) throws  SQLException {
        Integer id = results.getInt(10);
        String name = results.getString(11);
        Group group = new Group(id, name);
        return new GroupMembership(group);
    }

    @Override
    GroupMembership getRelevantMembership(List<GroupMembership> memberships, Integer id) {
        for (GroupMembership groupMembership : memberships) {
            if (groupMembership.getGroup().getId().equals(id)) {
                return groupMembership;
            }
        }
        return null;
    }

    @Override
    String getQueryForGetAll() {
        return "SELECT * FROM group_membership" +
                " LEFT JOIN users" +
                " ON group_membership.user_id = users.id" +
                " LEFT JOIN groups" +
                " ON group_membership.group_id = groups.id;";
    }

    @Override
    void addMentorToMembership(GroupMembership groupMembership, Mentor mentor) {
        groupMembership.addMentors(mentor);
    }

    @Override
    void addCodecoolerToMembership(GroupMembership groupMembership, Codecooler codecooler) {
        groupMembership.addCodecoolers(codecooler);
    }

    @Override
    void setInsertStatement(PreparedStatement ps, GroupMembership gm) {
    }

    @Override
    String getInsertQuery() {return "INSERT INTO group_membership (user_id, group_id) VALUES(?, ?);";}

}
