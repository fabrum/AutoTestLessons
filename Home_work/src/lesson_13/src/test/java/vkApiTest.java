
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.utils.URIBuilder;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.util.EntityUtils;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.io.IOException;
import java.net.URISyntaxException;


public class vkApiTest {
    String tokenForWall = "cb680071475557cf44ae5c6dbc4772cfe3dccae23424ca67ac5a6dd6e5fc4d5722ff8e3b17507b271252a";
    String ownerId = "234109484";
    String versionApi ="5.101";
    @Test
    public void SentPostOnWall()throws IOException, URISyntaxException {
        HttpClient client = HttpClientBuilder.create().build();
        String responsAll = GetAllWall();
        String countPostsBefor = responsAll.substring(responsAll.indexOf("count\":") + 7);
        countPostsBefor = countPostsBefor.substring(0, countPostsBefor.indexOf(",\""));

        URIBuilder builder = new URIBuilder("https://api.vk.com/method/wall.post?");
        builder.setParameter("access_token", tokenForWall)
                .setParameter("owner_id", ownerId)
                .setParameter("message", "test message")
                .setParameter("v", versionApi);

        HttpGet request = new HttpGet(builder.build());
        client.execute(request);
        String responsAllAfter =GetAllWall();
        String countPostsAfter = responsAllAfter.substring(responsAllAfter.indexOf("count\":") + 7);
        countPostsAfter = countPostsAfter.substring(0, countPostsAfter.indexOf(",\""));

        Assert.assertEquals(Integer.parseInt(countPostsBefor)+1,Integer.parseInt(countPostsAfter),"number of posts not increased");



    }


    @Test
    public void EditPostOnWall()throws IOException, URISyntaxException {
        HttpClient client = HttpClientBuilder.create().build();

        String responsAll =  GetAllWall();
        String postId = responsAll.substring(responsAll.indexOf("[{\"id\":") + 7);
        postId = postId.substring(0, postId.indexOf(",\""));

String newMessage ="edit_message";
        URIBuilder builderEdit = new URIBuilder("https://api.vk.com/method/wall.edit?");
        builderEdit.setParameter("access_token", tokenForWall)
                .setParameter("post_id", postId)
                .setParameter("v", versionApi)
                .setParameter("message", newMessage)
                .setParameter("owner_id", ownerId);

        HttpGet requestEdit = new HttpGet(builderEdit.build());
      client.execute(requestEdit);


        String  masseg =  GetAllWall();
        masseg =  masseg.substring( masseg.indexOf("\"text\":\"") + 8);
        masseg =  masseg.substring(0,  masseg.indexOf("\",\""));


        Assert.assertEquals(masseg,newMessage,"message not chang");

    }


    @Test
    public void DeletePostOnWall()throws IOException, URISyntaxException {
        HttpClient client = HttpClientBuilder.create().build();

        String responsAll =  GetAllWall();
        String countPostsBefor = responsAll.substring(responsAll.indexOf("count\":") + 7);
        countPostsBefor = countPostsBefor.substring(0, countPostsBefor.indexOf(",\""));
        String postId = responsAll.substring(responsAll.indexOf("[{\"id\":") + 7);
        postId = postId.substring(0, postId.indexOf(",\""));


        URIBuilder builderDel = new URIBuilder("https://api.vk.com/method/wall.delete?");
        builderDel.setParameter("access_token", tokenForWall)
                .setParameter("post_id", postId)
                .setParameter("v", versionApi)
                .setParameter("owner_id", ownerId);

        HttpGet requestDel = new HttpGet(builderDel.build());
        HttpResponse responseDel = client.execute(requestDel);

        String responsDel = (EntityUtils.toString(responseDel.getEntity()));
        Assert.assertEquals(responsDel,"{\"response\":1}");

        String responsAllAfter =  GetAllWall();
        String countPostsAfter = responsAllAfter.substring(responsAllAfter.indexOf("count\":") + 7);
        countPostsAfter = countPostsAfter.substring(0, countPostsAfter.indexOf(",\""));

        Assert.assertEquals(Integer.parseInt(countPostsBefor)-1,Integer.parseInt(countPostsAfter),"post don't delete");



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
    return  (EntityUtils.toString(responseAll.getEntity()));
}

}
