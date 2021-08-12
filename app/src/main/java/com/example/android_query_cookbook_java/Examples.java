package com.example.android_query_cookbook_java;

import android.util.Log;

import com.parse.ParseException;
import com.parse.ParseGeoPoint;
import com.parse.ParseObject;
import com.parse.ParseQuery;

import java.util.Calendar;
import java.util.Date;
import java.util.List;

public class Examples {
    private static final String TAG = "Examples";
}

class QueryRetrievers {
    private static final String TAG = "QueryRetrievers";

    public static void queryCancel() {
        ParseQuery<ParseObject> query = new ParseQuery<>("Profile");
        query.findInBackground();
        query.cancel();
    }

    public static void queryCount() {
        ParseQuery<ParseObject> query = new ParseQuery<>("Profile");
        try {
            int queryCount = query.count();
            Log.d(TAG, "Count: " + queryCount);
        } catch (com.parse.ParseException parseException) {
            parseException.printStackTrace();
        }
    }

    public static void queryFind() {
        //This find function works synchronously.
        ParseQuery<ParseObject> query = new ParseQuery<>("Profile");
        try {
            List<ParseObject> list = query.find();
            Log.d(TAG, "List: " + list);
        } catch (com.parse.ParseException e) {
            e.printStackTrace();
        }
    }

    public static void queryFindInBackground() {
        //This find function works asynchronously.
        ParseQuery<ParseObject> query = new ParseQuery<>("Profile");
        query.findInBackground((objects, e) -> {
            if (e == null) {
                Log.d(TAG, "Objects: " + objects);
            } else {
                Log.e(TAG, "ParseError: ", e);
            }
        });
    }

    public static void queryGet() {
        //We can call a parse object with an object id with the get() function.
        ParseQuery<ParseObject> query = new ParseQuery<>("Profile");
        try {
            ParseObject object = query.get("C6ENdLnFdQ");
            Log.d(TAG, "Object: " + object);
        } catch (ParseException e) {
            e.printStackTrace();
        }
    }

    public static void queryGetFirst() {
        //We can call a parse object with an object id with the get() function.
        ParseQuery<ParseObject> query = new ParseQuery<>("Profile");
        try {
            ParseObject firstItem = query.getFirst();
            Log.d(TAG, "First Item: " + firstItem);
        } catch (ParseException e) {
            e.printStackTrace();
        }
    }
}

class QueryConditioners {
    private static final String TAG = "QueryConditioners";

    public static void queryContainedIn() {
        ParseQuery<ParseObject> query = new ParseQuery<>("Profile");
        query.whereContainedIn("luckyNumbers", List.of(2, 7));
        query.findInBackground((objects, e) -> {
            if (e == null) {
                Log.d(TAG, "Objects: " + objects);
            } else {
                Log.e(TAG, "Parse Error: ", e);
            }

        });
    }

    public static void queryContains() {
        ParseQuery<ParseObject> query = new ParseQuery<>("Profile");
        query.whereContains("name", "da");
        query.findInBackground((objects, e) -> {
            if (e == null) {
                Log.d(TAG, "Objects: " + objects);
            } else {
                Log.e(TAG, "Parse Error: ", e);
            }

        });
    }

    public static void queryContainsAll() {
        ParseQuery<ParseObject> query = new ParseQuery<>("Profile");
        query.whereContainsAll("luckyNumbers", List.of(2, 7));
        query.findInBackground((objects, e) -> {
            if (e == null) {
                Log.d(TAG, "Objects: " + objects);
            } else {
                Log.e(TAG, "Parse Error: ", e);
            }

        });
    }

    public static void queryContainsAllStartingWith() {
        ParseQuery<ParseObject> query = new ParseQuery<>("Profile");
        query.whereContainsAllStartsWith("favoriteFoods", List.of("Shrimp", "Lobster"));
        query.findInBackground((objects, e) -> {
            if (e == null) {
                Log.d(TAG, "Objects: " + objects);
            } else {
                Log.e(TAG, "Parse Error: ", e);
            }

        });
    }

    public static void queryWhereDoesNotExist() {
        ParseQuery<ParseObject> query = new ParseQuery<>("Profile");
        query.whereDoesNotExist("premiumMembership");
        query.findInBackground((objects, e) -> {
            if (e == null) {
                Log.d(TAG, "Objects: " + objects);
            } else {
                Log.e(TAG, "Parse Error: ", e);
            }
        });
    }

    public static void queryDoesNotMatchKeyInQuery() {
        ParseQuery<ParseObject> query = new ParseQuery<>("Profile");
        ParseQuery<ParseObject> innerQuery = new ParseQuery<>("Profile");
        innerQuery.whereLessThan("friendCount", 50);
        query.whereDoesNotMatchKeyInQuery("friendCount", "friendCount", innerQuery);
        query.whereGreaterThan("friendCount", 10);
        query.findInBackground((objects, e) -> {
            if (e == null) {
                Log.d(TAG, "Objects: " + objects);
            } else {
                Log.e(TAG, "Parse Error: ", e);
            }
        });
    }

    public static void queryDoesNotMatchQuery() {
        ParseQuery<ParseObject> query = new ParseQuery<>("Profile");
        ParseQuery<ParseObject> innerQuery = new ParseQuery<>("Membership");
        innerQuery.whereGreaterThan("expirationDate", new Date());
        query.whereExists("premiumMembership");
        query.whereDoesNotMatchQuery("premiumMembership", innerQuery);
        query.findInBackground((objects, e) -> {
            if (e == null) {
                Log.d(TAG, "Objects: " + objects);
            } else {
                Log.e(TAG, "Parse Error: ", e);
            }
        });
    }

    public static void queryEndsWith() {
        ParseQuery<ParseObject> query = new ParseQuery<>("Profile");
        query.whereEndsWith("name", "ie");
        query.findInBackground((objects, e) -> {
            if (e == null) {
                Log.d(TAG, "Objects: " + objects);
            } else {
                Log.e(TAG, "Parse Error: ", e);
            }
        });
    }

    public static void queryEqualTo() {
        ParseQuery<ParseObject> query = new ParseQuery<>("Profile");
        query.whereEqualTo("friendCount", 2);
        query.findInBackground((objects, e) -> {
            if (e == null) {
                Log.d(TAG, "Objects: " + objects);
            } else {
                Log.e(TAG, "Parse Error: ", e);
            }
        });
    }

    public static void queryExists() {
        ParseQuery<ParseObject> query = new ParseQuery<>("Profile");
        query.whereExists("premiumMembership");
        query.findInBackground((objects, e) -> {
            if (e == null) {
                Log.d(TAG, "Objects: " + objects);
            } else {
                Log.e(TAG, "Parse Error: ", e);
            }
        });
    }

    public static void queryFullText() {
        ParseQuery<ParseObject> query = new ParseQuery<>("Profile");
        query.whereFullText("name", "Spears");
        query.findInBackground((objects, e) -> {
            if (e == null) {
                Log.d(TAG, "Objects: " + objects);
            } else {
                Log.e(TAG, "Parse Error: ", e);
            }
        });
    }

    public static void queryGreaterThan() {
        ParseQuery<ParseObject> query = new ParseQuery<>("Profile");
        Calendar calendar = Calendar.getInstance();
        calendar.set(1980, 8, 19, 59, 59, 59);
        Date date = calendar.getTime();
        query.whereGreaterThan("birthDay", date);
        query.findInBackground((objects, e) -> {
            if (e == null) {
                Log.d(TAG, "Objects: " + objects);
            } else {
                Log.e(TAG, "Parse Error: ", e);
            }
        });
    }

    public static void queryGreaterThanOrEqual() {
        ParseQuery<ParseObject> query = new ParseQuery<>("Profile");
        query.whereGreaterThanOrEqualTo("friendCount", 49);
        query.findInBackground((objects, e) -> {
            if (e == null) {
                Log.d(TAG, "Objects: " + objects);
            } else {
                Log.e(TAG, "Parse Error: ", e);
            }
        });
    }

    public static void queryLessThan() {
        ParseQuery<ParseObject> query = new ParseQuery<>("Profile");
        Calendar calendar = Calendar.getInstance();
        calendar.set(1980, 8, 19, 59, 59, 59);
        Date date = calendar.getTime();
        query.whereLessThan("birthDay", date);
        query.findInBackground((objects, e) -> {
            if (e == null) {
                Log.d(TAG, "Objects: " + objects);
            } else {
                Log.e(TAG, "Parse Error: ", e);
            }
        });
    }

    public static void queryLessThanOrEqual() {
        ParseQuery<ParseObject> query = new ParseQuery<>("Profile");
        query.whereLessThanOrEqualTo("friendCount", 49);
        query.findInBackground((objects, e) -> {
            if (e == null) {
                Log.d(TAG, "Objects: " + objects);
            } else {
                Log.e(TAG, "Parse Error: ", e);
            }
        });
    }

    public static void queryMatches() {
        ParseQuery<ParseObject> query = new ParseQuery<>("Profile");
        query.whereMatches("name", "da", "i");
        query.findInBackground((objects, e) -> {
            if (e == null) {
                Log.d(TAG, "Objects: " + objects);
            } else {
                Log.e(TAG, "Parse Error: ", e);
            }
        });
    }

    public static void queryMatchesInQuery() {
        ParseQuery<ParseObject> query = new ParseQuery<>("Profile");
        ParseQuery<ParseObject> innerQuery = new ParseQuery<>("Profile");
        innerQuery.whereLessThan("friendCount", 50);
        query.whereMatchesKeyInQuery("friendCount", "friendCount", innerQuery);
        query.whereGreaterThan("friendCount", 10);
        query.findInBackground((objects, e) -> {
            if (e == null) {
                Log.d(TAG, "Objects: " + objects);
            } else {
                Log.e(TAG, "Parse Error: ", e);
            }
        });
    }

    public static void queryMatchesQuery() {
        ParseQuery<ParseObject> query = new ParseQuery<>("Profile");
        ParseQuery<ParseObject> innerQuery = new ParseQuery<>("Membership");
        innerQuery.whereGreaterThan("expirationDate", new Date());
        query.whereExists("premiumMembership");
        query.whereMatchesQuery("premiumMembership", innerQuery);
        query.findInBackground((objects, e) -> {
            if (e == null) {
                Log.d(TAG, "Objects: " + objects);
            } else {
                Log.e(TAG, "Parse Error: ", e);
            }
        });
    }

    public static void queryNotEqualTo() {
        ParseQuery<ParseObject> query = new ParseQuery<>("Profile");
        query.whereNotEqualTo("friendCount", 2);
        query.findInBackground((objects, e) -> {
            if (e == null) {
                Log.d(TAG, "Objects: " + objects);
            } else {
                Log.e(TAG, "Parse Error: ", e);
            }
        });
    }

    public static void queryStartsWith() {
        ParseQuery<ParseObject> query = new ParseQuery<>("Profile");
        query.whereStartsWith("name", "Brit");
        query.findInBackground((objects, e) -> {
            if (e == null) {
                Log.d(TAG, "Objects: " + objects);
            } else {
                Log.e(TAG, "Parse Error: ", e);
            }
        });
    }
}

class QueryOrdering {
    private static final String TAG = "QueryOrdering";

    public static void queryAddAscending() {
        ParseQuery<ParseObject> query = new ParseQuery<>("Profile");
        query.addAscendingOrder("friendCount");
        query.findInBackground((objects, e) -> {
            if (e == null) {
                Log.d(TAG, "Objects: " + objects);
            } else {
                Log.e(TAG, "Parse Error: ", e);
            }

        });
    }

    public static void queryAddDescending() {
        ParseQuery<ParseObject> query = new ParseQuery<>("Profile");
        query.addDescendingOrder("friendCount");
        query.findInBackground((objects, e) -> {
            if (e == null) {
                Log.d(TAG, "Objects: " + objects);
            } else {
                Log.e(TAG, "Parse Error: ", e);
            }

        });
    }

    public static void queryAscending() {
        ParseQuery<ParseObject> query = new ParseQuery<>("Profile");
        query.orderByAscending("friendCount");
        query.findInBackground((objects, e) -> {
            if (e == null) {
                Log.d(TAG, "Objects: " + objects);
            } else {
                Log.e(TAG, "Parse Error: ", e);
            }

        });
    }

    public static void queryDescending() {
        ParseQuery<ParseObject> query = new ParseQuery<>("Profile");
        query.orderByDescending("friendCount");
        query.findInBackground((objects, e) -> {
            if (e == null) {
                Log.d(TAG, "Objects: " + objects);
            } else {
                Log.e(TAG, "Parse Error: ", e);
            }

        });
    }
}

class FieldSelecting {
    private static final String TAG = "FieldSelecting";

    public static void queryInclude() {
        ParseQuery<ParseObject> query = new ParseQuery<>("Profile");
        query.whereExists("premiumMembership");
        query.include("premiumMembership");
        query.findInBackground((objects, e) -> {
            if (e == null) {
                Log.d(TAG, "Objects: " + objects);
                Log.d(TAG, "Object Premium Membership: " + objects.get(0).get("premiumMembership"));
            } else {
                Log.e(TAG, "Parse Error: ", e);
            }

        });
    }

    public static void querySelect() {
        ParseQuery<ParseObject> query = new ParseQuery<>("Profile");
        query.selectKeys(List.of("name"));
        query.findInBackground((objects, e) -> {
            if (e == null) {
                Log.d(TAG, "Objects: " + objects);
                Log.d(TAG, "Object name: " + objects.get(0).get("name"));
            } else {
                Log.e(TAG, "Parse Error: ", e);
            }

        });
    }
}

class GeoPointQuerying {
    private static final String TAG = "GeoPointQuerying";

    public static void queryNear() {
        ParseQuery<ParseObject> query = new ParseQuery<>("Profile");
        query.whereNear("lastLoginLocation", new ParseGeoPoint(37.38412167489413, -122.01268034622319));
        query.findInBackground((objects, e) -> {
            if (e == null) {
                Log.d(TAG, "Objects: " + objects);
            } else {
                Log.e(TAG, "Parse Error: ", e);
            }

        });
    }

    public static void queryPolygonContains() {
        ParseQuery<ParseObject> query = new ParseQuery<>("Profile");
        query.wherePolygonContains("lastLoginLocation", new ParseGeoPoint(37.38412167489413, -122.01268034622319));
        query.findInBackground((objects, e) -> {
            if (e == null) {
                Log.d(TAG, "Objects: " + objects);
            } else {
                Log.e(TAG, "Parse Error: ", e);
            }

        });
    }

    public static void queryWithinGeoBox() {
        ParseQuery<ParseObject> query = new ParseQuery<>("Profile");
        query.whereWithinGeoBox("lastLoginLocation", new ParseGeoPoint(37.48412167489413, -122.11268034622319), new ParseGeoPoint(37.28412167489413, -121.91268034622319));
        query.findInBackground((objects, e) -> {
            if (e == null) {
                Log.d(TAG, "Objects: " + objects);
            } else {
                Log.e(TAG, "Parse Error: ", e);
            }

        });
    }

    public static void queryWithinKilometers() {
        ParseQuery<ParseObject> query = new ParseQuery<>("Profile");
        query.whereWithinKilometers("lastLoginLocation", new ParseGeoPoint(37.38412167489413, -122.01268034622319), 100);
        query.findInBackground((objects, e) -> {
            if (e == null) {
                Log.d(TAG, "Objects: " + objects);
            } else {
                Log.e(TAG, "Parse Error: ", e);
            }

        });
    }

    public static void queryWithinMiles() {
        ParseQuery<ParseObject> query = new ParseQuery<>("Profile");
        query.whereWithinMiles("lastLoginLocation", new ParseGeoPoint(37.38412167489413, -122.01268034622319), 100);
        query.findInBackground((objects, e) -> {
            if (e == null) {
                Log.d(TAG, "Objects: " + objects);
            } else {
                Log.e(TAG, "Parse Error: ", e);
            }

        });
    }

    public static void queryWithinPolygon() {
        ParseQuery<ParseObject> query = new ParseQuery<>("Profile");
        query.whereWithinPolygon("lastLoginLocation", List.of(new ParseGeoPoint(37.48412167489413, -122.11268034622319),
                new ParseGeoPoint(37.48412167489413, -121.91268034622319),
                new ParseGeoPoint(37.28412167489413, -121.91268034622319),
                new ParseGeoPoint(37.28412167489413, -122.01268034622319)));
        query.findInBackground((objects, e) -> {
            if (e == null) {
                Log.d(TAG, "Objects: " + objects);
            } else {
                Log.e(TAG, "Parse Error: ", e);
            }

        });
    }

    public static void queryWithinRadians() {
        ParseQuery<ParseObject> query = new ParseQuery<>("Profile");
        query.whereWithinRadians("lastLoginLocation", new ParseGeoPoint(37.38412167489413, -122.01268034622319), 100);
        query.findInBackground((objects, e) -> {
            if (e == null) {
                Log.d(TAG, "Objects: " + objects);
            } else {
                Log.e(TAG, "Parse Error: ", e);
            }

        });
    }
}

class Pagination {
    private static final String TAG = "Pagination";

    public static void queryLimit() {
        ParseQuery<ParseObject> query = new ParseQuery<>("Profile");
        query.setLimit(2);
        query.findInBackground((objects, e) -> {
            if (e == null) {
                Log.d(TAG, "Objects: " + objects);
            } else {
                Log.e(TAG, "Parse Error: ", e);
            }

        });
    }

    public static void querySkip() {
        ParseQuery<ParseObject> query = new ParseQuery<>("Profile");
        query.setSkip(2);
        query.findInBackground((objects, e) -> {
            if (e == null) {
                Log.d(TAG, "Objects: " + objects);
            } else {
                Log.e(TAG, "Parse Error: ", e);
            }

        });
    }
}

class LocalDataStore {
    private static final String TAG = "LocalDataStore";

    public static void queryFromLocalDataStore() {
        ParseQuery<ParseObject> query = new ParseQuery<>("Profile");
        //If you want use LocalDataStore you should enable local data store in the App.java or App.kt file.
        query.fromLocalDatastore();
        query.findInBackground((objects, e) -> {
            if (e == null) {
                Log.d(TAG, "Objects: " + objects);
            } else {
                Log.e(TAG, "Parse Error: ", e);
            }

        });
    }

    public static void queryFromNetwork() {
        ParseQuery<ParseObject> query = new ParseQuery<>("Profile");
        query.fromNetwork();
        query.findInBackground((objects, e) -> {
            if (e == null) {
                Log.d(TAG, "Objects: " + objects);
            } else {
                Log.e(TAG, "Parse Error: ", e);
            }

        });
    }

    public static void queryFromPin() {
        ParseQuery<ParseObject> query = new ParseQuery<>("Profile");
        query.fromPin();
        query.findInBackground((objects, e) -> {
            if (e == null) {
                Log.d(TAG, "Objects: " + objects);
            } else {
                Log.e(TAG, "Parse Error: ", e);
            }

        });
    }

    public static void queryFromPinWithName() {
        ParseQuery<ParseObject> query = new ParseQuery<>("Profile");
        query.fromPin("pinnedObjects");
        query.findInBackground((objects, e) -> {
            if (e == null) {
                Log.d(TAG, "Objects: " + objects);
            } else {
                Log.e(TAG, "Parse Error: ", e);
            }
        });
    }

}