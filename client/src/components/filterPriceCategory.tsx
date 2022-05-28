import React, { Component } from 'react'
import MenuItem from '@mui/material/MenuItem';
import FormControl from '@mui/material/FormControl';
import Select, { SelectChangeEvent } from '@mui/material/Select';
import { FilterProps } from './filter';
import PriceCategory from '../model/priceCategory';
import Box from '@mui/material/Box';
import InputLabel from '@mui/material/InputLabel';

const FilterPriceCategory: React.FC<FilterProps> = ({ filter, setFilter }) => {

    const parsePrice = (n: number): PriceCategory => {
        switch (n) {
            case 0:
                return 0
            case 1:
                return 1
            case 2:
                return 2
            default:
                return 1;
        }
    };

    const handlePriceCategory = (
        event: SelectChangeEvent,
    ) => {
        setFilter({
            ...filter,
            price: parsePrice(parseInt(event.target.value))
        })
    }

    const renderPriceCategory = (): JSX.Element => {
        return <Box sx={{ maxWidth: 120 }}>
            <FormControl fullWidth>
                <InputLabel id="price-checkbox-label">Preis</InputLabel>
                <Select
                    labelId='price-checkbox-label'
                    value={filter["price"]?.toString()}
                    onChange={handlePriceCategory}
                >
                    <MenuItem value={0}>€</MenuItem>
                    <MenuItem value={1}>€€</MenuItem>
                    <MenuItem value={2}>€€€</MenuItem>
                </Select>
            </FormControl>
        </Box>
    }

    return (
        renderPriceCategory()
    )
}

export default FilterPriceCategory
