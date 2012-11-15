import com.borja.socialsearch.Item
/**
 * Created with IntelliJ IDEA.
 * User: borja
 * Date: 11/15/12
 * Time: 12:01 AM
 * To change this template use File | Settings | File Templates.
 */
public interface ISocialApi {


    List<Item> searchItems(tag, siteKey, max, connTimeout, readTimeout)

}