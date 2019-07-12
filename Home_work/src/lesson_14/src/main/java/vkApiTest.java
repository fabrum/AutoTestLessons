import org.apache.log4j.Logger;
import org.junit.Assert;
import org.junit.Test;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.utils.URIBuilder;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.util.EntityUtils;

import java.io.IOException;
import java.net.URISyntaxException;

public class vkApiTest {
    String tokenForWall = "eacce343b6d41eb824449c5414ba8fc404ddd958bcb8b2601969c335235f5555624b1f09b03823f632872";
    String ownerId = "234109484";
    String versionApi ="5.101";
    private  static final Logger log = Logger.getLogger(vkApiTest.class);
    @Test
    public void SentPostOnWall()throws IOException, URISyntaxException {
        HttpClient client = HttpClientBuilder.create().build();
        String responsAll = GetAllWall();
        String countPostsBefor = responsAll.substring(responsAll.indexOf("count\":") + 7);
        countPostsBefor = countPostsBefor.substring(0, countPostsBefor.indexOf(",\""));
        log.info("get the number of posts on the wall");
        URIBuilder builder = new URIBuilder("https://api.vk.com/method/wall.post?");
        builder.setParameter("access_token", tokenForWall)
                .setParameter("owner_id", ownerId)
                .setParameter("message", "test message")
                .setParameter("v", versionApi);

        HttpGet request = new HttpGet(builder.build());
        client.execute(request);
        log.info("set new post on wall");
        String responsAllAfter =GetAllWall();
        String countPostsAfter = responsAllAfter.substring(responsAllAfter.indexOf("count\":") + 7);
        countPostsAfter = countPostsAfter.substring(0, countPostsAfter.indexOf(",\""));
        log.info("get the number of posts on the wall after new post");
        Assert.assertEquals("number of posts not increased",Integer.parseInt(countPostsBefor)+1,Integer.parseInt(countPostsAfter));
        log.info("check that the number of posts increased by 1");


    }


    @Test
    public void EditPostOnWall()throws IOException, URISyntaxException {
        HttpClient client = HttpClientBuilder.create().build();

        String responsAll =  GetAllWall();

        String postId = responsAll.substring(responsAll.indexOf("[{\"id\":") + 7);
        postId = postId.substring(0, postId.indexOf(",\""));
        log.info("get ID last post on the wall");
        String newMessage ="edit_message";
        URIBuilder builderEdit = new URIBuilder("https://api.vk.com/method/wall.edit?");
        builderEdit.setParameter("access_token", tokenForWall)
                .setParameter("post_id", postId)
                .setParameter("v", versionApi)
                .setParameter("message", newMessage)
                .setParameter("owner_id", ownerId);

        HttpGet requestEdit = new HttpGet(builderEdit.build());
        client.execute(requestEdit);
        log.info("edit 'message' in last post on the wall");

        String  masseg =  GetAllWall();
        masseg =  masseg.substring( masseg.indexOf("\"text\":\"") + 8);
        masseg =  masseg.substring(0,  masseg.indexOf("\",\""));
        log.info("get 'message' last post on the wall");

        Assert.assertEquals("message not chang",masseg,newMessage);
        log.info("check message is changed ");
    }


    @Test
    public void DeletePostOnWall()throws IOException, URISyntaxException {
        HttpClient client = HttpClientBuilder.create().build();

        String responsAll =  GetAllWall();
        String countPostsBefor = responsAll.substring(responsAll.indexOf("count\":") + 7);
        countPostsBefor = countPostsBefor.substring(0, countPostsBefor.indexOf(",\""));
        log.info("get the number of posts on the wall");
        String postId = responsAll.substring(responsAll.indexOf("[{\"id\":") + 7);
        postId = postId.substring(0, postId.indexOf(",\""));
        log.info("get ID last post on the wall");

        URIBuilder builderDel = new URIBuilder("https://api.vk.com/method/wall.delete?");
        builderDel.setParameter("access_token", tokenForWall)
                .setParameter("post_id", postId)
                .setParameter("v", versionApi)
                .setParameter("owner_id", ownerId);

        HttpGet requestDel = new HttpGet(builderDel.build());
        HttpResponse responseDel = client.execute(requestDel);
        log.info("delete last post on the wall");
        String responsDel = (EntityUtils.toString(responseDel.getEntity()));
        Assert.assertEquals(responsDel,"{\"response\":1}");
        log.info("check the response after deleted last post");
        String responsAllAfter =  GetAllWall();
        String countPostsAfter = responsAllAfter.substring(responsAllAfter.indexOf("count\":") + 7);
        countPostsAfter = countPostsAfter.substring(0, countPostsAfter.indexOf(",\""));
        log.info("get the number of posts on the wall after delete post");
        Assert.assertEquals("post don't delete",Integer.parseInt(countPostsBefor)-1,Integer.parseInt(countPostsAfter));

        log.info("check that the number of posts has decreased by 1");

    }

    public String GetAllWall()throws IOException, URISyntaxException
    {
        HttpClient client = HttpClientBuilder.create().build();

        URIBuilder builderAll = new URIBuilder("https://api.vk.com/method/wall.get?");
        builderAll.setParameter("access_token", tokenForWall)
                .setParameter("owner_id", ownerId)
                .setParameter("v", versionApi);
        HttpGet requestAll = new HttpGet(builderAll.build());
        HttpResponse responseAll = client.execute(requestAll);
        log.info("get all posts in wall API");
        return  (EntityUtils.toString(responseAll.getEntity()));
    }

}
