import { Button, Rating, Typography, Paper } from '@mui/material';
import { Component } from 'react';
import Restaurant from '../model/restaurant';
import Review from '../model/review';
import styles from '../styles/restaurantDetails.module.css';
import commonStyles from '../styles/common.module.css';
import OpeningTimes from './openingTimes';
import ReviewComponent from './review';
import PriceCategory from './priceCategory';
import { getReviews } from '../model/api';

export class RestaurantDetails extends Component<{ restaurant: Restaurant, onClose?: VoidFunction, onReserve?: VoidFunction }, { reviews: Array<Review>, brokenImages: Array<number> }> {

    constructor(props: any) {
        super(props);

        this.state = {
            reviews: [],
            brokenImages: [],
        };
    }

    componentDidMount() {
        getReviews(this.props.restaurant.id).then(reviews => this.setState({ reviews: reviews }));
    }

    render() {
        const restaurant = this.props.restaurant;
        return (
            <div className={styles.container}>
                <div className={styles.grid}>
                    <Typography variant="h4" className={commonStyles["restaurant-name-overflow"]}>{restaurant.name}</Typography>
                    <div className={commonStyles["left-right"] + ' ' + styles["price-rating"]}>
                        <PriceCategory category={restaurant.priceCategory} />
                        <Rating readOnly value={restaurant.rating} />
                    </div>
                    <Paper className={styles["default-container"]} >
                        <Typography>{restaurant.cuisines.join(", ")}</Typography>
                        <a href={restaurant.website}><Typography>{restaurant.website}</Typography></a>
                        <Typography>{restaurant.location.address}</Typography>
                    </Paper>
                    <Paper className={styles["default-container"]} >
                        <OpeningTimes times={restaurant.open} />
                    </Paper>
                </div>
                {this.props.restaurant.images.filter((_, i) => !this.state.brokenImages.includes(i)).length > 0 &&
                    <Paper className={styles["images-container"]}>
                        <div className={styles["images"]}>
                            {this.props.restaurant.images.map((image, index) =>
                                <img key={index} src={image} onError={e => {
                                    (e.target as HTMLImageElement).style.display = 'none';
                                    if (!this.state.brokenImages.includes(index))
                                        this.setState(prevState => ({ brokenImages: [...prevState.brokenImages, index] }));
                                }} />)
                            }
                        </div>
                    </Paper>
                }
                {this.state.reviews.length > 0 &&
                    <div className={styles["reviews-container"]}>
                        {this.state.reviews.map((review, index) => <Paper key={index} elevation={2}><ReviewComponent review={review} /></Paper>)}
                    </div>
                }
                <div className={commonStyles["left-right"]}>
                    <Button onClick={this.props.onClose} variant="outlined" color="secondary">Abbrechen</Button>
                    <Button onClick={this.props.onReserve} variant="contained" color="primary">Reservieren</Button>
                </div>
            </div>
        );
    }
}

export default RestaurantDetails;