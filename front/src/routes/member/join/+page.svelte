<script lang="ts">
    import rq from '$lib/rq/rq.svelte';

    async function submitJoinForm(this: HTMLFormElement) {
        const form: HTMLFormElement = this;

        const response = await rq.apiEndPoints().POST('/api/member/join', {
            body: {
                username: form.username.value.trim(),
                password: form.password.value.trim()
            }
        });
        
        // if 문

    }
</script>

<style>
    body {
        background-color: #222; /* 배경색을 블랙 톤으로 설정 */
        font-family: Arial, sans-serif; /* 글꼴 설정 */
        display: flex;
        justify-content: center;
        align-items: center;
        height: 100vh; /* 화면 높이에 맞게 가운데 정렬 */
        margin: 0;
        justify-content: flex-start; /* 폼을 왼쪽으로 정렬 */
        padding-left: 25%;
    }

    h1 {
        font-size: 24px; /* 제목의 글자 크기를 크게 설정 */
        color: #fff; /* 제목의 글자 색상을 흰색으로 설정 */
        margin-bottom: 20px; /* 제목 아래 여백 추가 */
        text-align: left; /* 제목을 왼쪽 정렬 */
    }

    .login-container {
        /* 기존 스타일 유지 */
        border-radius: 5px; /* 테두리를 더 각지게 조정 */
        width: 50%;
    }

    .form-group {
        margin-bottom: 20px;
        border-bottom: 1px solid #ccc; /* 각 폼 그룹 아래에 구분선 추가 */
        padding-bottom: 10px; /* 구분선과 폼 요소 사이 간격 추가 */
    }

    .form-group:last-child {
        border-bottom: none; /* 마지막 폼 그룹의 구분선 제거 */
    }
    
    .form-group label {
        display: block;
        font-weight: bold;
        margin-bottom: 5px;
    }

    .form-group input {
        width: 100%;
        padding: 10px;
        border: 1px solid #ccc;
        border-radius: 5px;
        font-size: 16px;
    }

    .join-button {
        background-color: #333; /* 블랙 톤 배경색 설정 */
        color: #fff; /* 흰색 글자색 설정 */
        border: none;
        border-radius: 5px;
        padding: 10px 20px;
        font-size: 18px;
        cursor: pointer;
    }

    .join-button:hover {
        background-color: #444; /* 호버 시 배경색 변경 */
    }
</style>

<div class="login-container">
    <h1>회원가입</h1>
    <form on:submit|preventDefault={submitJoinForm}>
        <div class="form-group">
            <label for="username">아이디</label>
            <input type="text" id="username" name="username" placeholder="아이디를 입력하세요" required />
        </div>
        <div class="form-group">
            <label for="password">비밀번호</label>
            <input type="password" id="password" name="password" placeholder="비밀번호를 입력하세요" required />
        </div>
        <button class="join-button" type="submit">가입하기</button>
    </form>
</div>
