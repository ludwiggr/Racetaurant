import { Typography } from '@mui/material';
import React, { Component } from 'react'
import Category from '../model/priceCategory';

export class PriceCategory extends Component<{ category: Category }, {}> {
    render() {
        return (
            <Typography variant='body1'>{'€'.repeat(this.props.category + 1)}</Typography>
        )
    }
}

export default PriceCategory;
