import Box from '@mui/material/Box';
import FormControl from '@mui/material/FormControl';
import InputLabel from '@mui/material/InputLabel';
import MenuItem from '@mui/material/MenuItem';
import Select from '@mui/material/Select';
import React from 'react';
import PriceCategory, { isPriceCategory } from '../model/priceCategory';

const FilterPriceCategory: React.FC<{ priceCategory: PriceCategory, setPriceCategory: (priceCategory: PriceCategory) => void }> = ({ priceCategory, setPriceCategory }) => {

    return (
        <Box sx={{ maxWidth: 120 }}>
            <FormControl fullWidth>
                <InputLabel id="price-checkbox-label">Preis</InputLabel>
                <Select
                    labelId='price-checkbox-label'
                    value={priceCategory}
                    onChange={(e) => isPriceCategory(e.target.value) && setPriceCategory(e.target.value)}
                >
                    <MenuItem value={0}>€</MenuItem>
                    <MenuItem value={1}>€€</MenuItem>
                    <MenuItem value={2}>€€€</MenuItem>
                </Select>
            </FormControl>
        </Box>
    );
}

export default FilterPriceCategory
