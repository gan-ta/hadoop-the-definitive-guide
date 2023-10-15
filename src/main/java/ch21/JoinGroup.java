package ch21;

import org.apache.zookeeper.CreateMode;
import org.apache.zookeeper.KeeperException;
import org.apache.zookeeper.ZooDefs;

/*
 * 멤버를 그룹에 등록
 */
public class JoinGroup extends ConnectionWatcher{
    public void join(String groupName, String memberName) throws KeeperException, InterruptedException {
        String path = "/" + groupName + "/" + memberName;
        String createdPath = zk.create(path, null, ZooDefs.Ids.OPEN_ACL_UNSAFE, CreateMode.EPHEMERAL);
        System.out.println("Created " + createdPath);
    }

    public static void main(String[] args) throws Exception {
        JoinGroup joinGroup = new JoinGroup();
        joinGroup.connect("localhost");
        joinGroup.join("zoo", "duck");

        Thread.sleep(Long.MAX_VALUE);
    }
}
