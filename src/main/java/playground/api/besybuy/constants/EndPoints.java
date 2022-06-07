package playground.api.besybuy.constants;

/**
 * Created by Jay
 */
public class EndPoints {

    /**
     * This is Endpoints of Bestbuy/PRODUCTS api
     */
    public static final String GET_ALL_PRODUCTS = "/products";
    public static final String GET_SINGLE_PRODUCT_BY_ID = "/products/{id}";
    public static final String CREATE_PRODUCTS = "/products";
    public static final String PATCH_PRODUCT_BY_ID = "/products/{id}";
    public static final String DELETE_PRODUCT_BY_ID = "/products/{id}";

    /**
     * This is Endpoints of BESTBUY/STORES api
     */
    public static final String GET_ALL_STORES = "";
    public static final String GET_STORE_BY_ID = "/{id}";
    public static final String CREATE_STORE = "";
    public static final String PATCH_STORE_BY_ID = "/{id}";
    public static final String DELETE_STORE_BY_ID = "/{id}";
    /**
     * This is Endpoints of BESTBUY/CATEGORIES api
     */
    public static final String GET_ALL_CATEGORIES= "";
    public static final String GET_CATEGORIES_BY_ID = "/{id}";
    public static final String CREATE_CATEGORIES = "";
    public static final String UPDATE_CATEGORIES_BY_ID = "/{id}";
    public static final String DELETE_CATEGORIES_BY_ID = "/{id}";
    /**
     * This is Endpoints of BESTBUY/SERVICES api
     */
    public static final String GET_ALL_SERVICES = "";
    public static final String GET_SERVICES_BY_ID = "/{id}";
    public static final String CREATE_SERVICES = "";
    public static final String UPDATE_SERVICES_BY_ID = "/{id}";
    public static final String DELETE_SERVICES_BY_ID="/{id}";

    /**
     * This is Endpoints of BESTBUY/UTILITIES api
     */
    public static final String GET_VERSION = "/version";
    public static final String GET_HEALTHCHECK = "/healthcheck";



}
