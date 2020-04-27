package cn.sabercon.algorithm.q400.q360;

import javafx.util.Pair;

import java.util.*;

/**
 * Design Twitter
 * <p>
 * Design a simplified version of Twitter where users can post tweets, follow/unfollow another user and is able to see the 10 most recent tweets in the user's news feed.
 * Your design should support the following methods:
 * <p>
 * postTweet(userId, tweetId): Compose a new tweet.
 * getNewsFeed(userId): Retrieve the 10 most recent tweet ids in the user's news feed.
 * Each item in the news feed must be posted by users who the user followed or by the user herself.
 * Tweets must be ordered from most recent to least recent.
 * follow(followerId, followeeId): Follower follows a followee.
 * unfollow(followerId, followeeId): Follower unfollows a followee.
 * Example:
 * <p>
 * Twitter twitter = new Twitter();
 * <p>
 * // User 1 posts a new tweet (id = 5).
 * twitter.postTweet(1, 5);
 * <p>
 * // User 1's news feed should return a list with 1 tweet id -> [5].
 * twitter.getNewsFeed(1);
 * <p>
 * // User 1 follows user 2.
 * twitter.follow(1, 2);
 * <p>
 * // User 2 posts a new tweet (id = 6).
 * twitter.postTweet(2, 6);
 * <p>
 * // User 1's news feed should return a list with 2 tweet ids -> [6, 5].
 * // Tweet id 6 should precede tweet id 5 because it is posted after tweet id 5.
 * twitter.getNewsFeed(1);
 * <p>
 * // User 1 unfollows user 2.
 * twitter.unfollow(1, 2);
 * <p>
 * // User 1's news feed should return a list with 1 tweet id -> [5],
 * // since user 1 is no longer following user 2.
 * twitter.getNewsFeed(1);
 *
 * @author ywk
 * @date 2020-04-27
 */
public class Q355 {

    Map<Integer, HashSet<Integer>> followMap;

    Map<Integer, TreeMap<Long, Integer>> tweetMap;

    /**
     * Initialize your data structure here.
     */
    public Q355() {
        followMap = new HashMap<>();
        tweetMap = new HashMap<>();
    }

    /**
     * Compose a new tweet.
     */
    public void postTweet(int userId, int tweetId) {
        tweetMap.computeIfAbsent(userId, k -> new TreeMap<>(Comparator.reverseOrder()))
                .put(System.nanoTime(), tweetId);
    }

    /**
     * Retrieve the 10 most recent tweet ids in the user's news feed.
     * Each item in the news feed must be posted by users who the user followed or by the user herself.
     * Tweets must be ordered from most recent to least recent.
     */
    public List<Integer> getNewsFeed(int userId) {
        PriorityQueue<Pair<Long, Integer>> heap = new PriorityQueue<>(10, Comparator.comparingLong(Pair::getKey));
        getNewsTweets(heap, userId);
        if (followMap.containsKey(userId)) {
            followMap.get(userId).forEach(followeeId -> {
                getNewsTweets(heap, followeeId);
            });
        }
        List<Integer> ans = new ArrayList<>(10);
        while (!heap.isEmpty()) {
            ans.add(heap.poll().getValue());
        }
        Collections.reverse(ans);
        return ans;
    }

    private void getNewsTweets(PriorityQueue<Pair<Long, Integer>> heap, Integer userId) {
        if (!tweetMap.containsKey(userId)) {
            return;
        }
        for (Map.Entry<Long, Integer> entry : tweetMap.get(userId).entrySet()) {
            Long time = entry.getKey();
            Integer tweetId = entry.getValue();
            if (heap.size() < 10) {
                heap.add(new Pair<>(time, tweetId));
            } else if (heap.peek().getKey() > time) {
                break;
            } else {
                heap.add(new Pair<>(time, tweetId));
                heap.poll();
            }
        }
    }

    /**
     * Follower follows a followee. If the operation is invalid, it should be a no-op.
     */
    public void follow(int followerId, int followeeId) {
        if (followerId == followeeId) {
            return;
        }
        followMap.computeIfAbsent(followerId, k -> new HashSet<>()).add(followeeId);
    }

    /**
     * Follower unfollows a followee. If the operation is invalid, it should be a no-op.
     */
    public void unfollow(int followerId, int followeeId) {
        if (followMap.containsKey(followerId)) {
            followMap.get(followerId).remove(followeeId);
        }
    }
}
