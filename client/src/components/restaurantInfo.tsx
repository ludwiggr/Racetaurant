import React, { Component } from 'react'
import { Button, Rating, Typography } from '@mui/material';
import Restaurant from '../model/restaurant';
import styles from '../styles/restaurantInfo.module.css'
import PriceCategory from './priceCategory';


export class RestaurantInfo extends Component<{ restaurant: Restaurant }, {}>{
    render() {
        const restaurant = this.props.restaurant;
        return (
            <>
                <div>
                    <div className={styles.container}>
                        <div className={styles.content}>
                            {/*Content*/}
                            <Typography variant='h4'>{restaurant.name}</Typography>

                            <div className={styles.container}>
                                <Rating name="read-only" value={restaurant.rating} readOnly />
                                <PriceCategory category={restaurant.priceCategory} />
                            </div>

                            <div className={styles.container}>
                                <Typography variant='body1'>{restaurant.location.address}</Typography>
                                <Typography variant='body1'>{restaurant.cuisines.join(', ')}</Typography>
                            </div>

                        </div>
                        {/*Bild nur wenn es eins gibt*/}
                        {restaurant.images.length > 0 && <img className={styles.image} src={restaurant.images[0]} />}
                    </div>

                    <Button style={{ marginTop: '8px' }} variant="contained" color='primary' fullWidth>see more details</Button>

                </div>
                {/*Hintergrund*/}
            </>

        )
    }
}

export default RestaurantInfo;
