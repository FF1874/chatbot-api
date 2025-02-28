package cn.foolish.chatbot.domain.zsxq;

import cn.foolish.chatbot.domain.zsxq.model.aggregates.UnAnsweredQuestionsAggregates;

import java.io.IOException;

public interface IZsxqApi {
    UnAnsweredQuestionsAggregates queryUnAnsweredQuestionsTopicsId(String groupId, String cookie) throws IOException;

    boolean answer(String groupId, String cookie, String topicId, String text) throws IOException;
}
