import React from 'react';
import { useNavigate } from 'react-router-dom';

const LottoPage: React.FC = () => {
    const navigate = useNavigate();

    return (
        <div className="lotto-page">
            <div className="lotto-container">

                <h1 className="lotto-title">로또 메인 페이지</h1>
            </div>
        </div>
    );
};

export default LottoPage;
