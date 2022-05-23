import Cuisine from "./cuisine";
import Location from "./location";
import OpeningTimes from "./openingTimes";
import PriceCategory from "./priceCategory";
import RestaurantLayout from "./restaurantLayout";

class Restaurant {
    id: string;
    name: string;
    website: string;
    rating: number;
    images: Array<string>;
    priceCategory: PriceCategory;
    cuisines: Array<Cuisine>;
    location: Location;
    layout: RestaurantLayout;
    open: OpeningTimes;


    constructor(
        id: string,
        name: string,
        website: string,
        rating: number,
        images: Array<string>,
        priceCategory: PriceCategory,
        cuisines: Array<Cuisine>,
        location: Location,
        layout: RestaurantLayout,
        open: OpeningTimes
    ) {
        this.id = id
        this.name = name
        this.website = website
        this.rating = rating
        this.images = images
        this.priceCategory = priceCategory
        this.cuisines = cuisines
        this.location = location
        this.layout = layout
        this.open = open
    }

}

export default Restaurant;